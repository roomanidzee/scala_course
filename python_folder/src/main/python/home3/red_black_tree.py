from typing import List

from optional import Optional

from home3.enums import NTE


class NullNode:

    def __init__(self, value=0, color=NTE.BLACK, left=None, right=None, parent=None):

        self.value = value
        self.color = color
        self.left = left
        self.right = right
        self.parent = parent


NIL = NullNode()


class RedBlackNode(NullNode):

    def __init__(self, value, color=NTE.RED, left=NIL, right=NIL, parent=NIL):
        super().__init__(value, color, left, right, parent)
        self.value = value
        self.color = color
        self.left = left
        self.right = right
        self.parent = parent


class Tree:

    def __init__(self, root=NIL):
        self.root = root

    def rotate_left(self, x: RedBlackNode):

        y = x.right
        x.right = y.left

        if y.left != NIL:
            y.left.parent = x

        y.parent = x.parent

        if x.parent == NIL:
            self.root = y
        elif x == x.parent.left:
            x.parent.left = y
        else:
            x.parent.right = y

        y.left = x
        x.parent = y

    def rotate_right(self, x: RedBlackNode):

        y = x.left
        x.left = y.right

        if y.right != NIL:
            y.right.parent = x

        y.parent = x.parent

        if x.parent == NIL:
            self.root = y
        elif x == x.parent.right:
            x.parent.right = y
        else:
            x.parent.left = y

        y.right = x
        x.parent = y

    def simple_insert(self, z: RedBlackNode):

        y = NIL
        x = self.root

        while x != NIL:
            y = x

            if z.value < x.value:
                x = x.left
            else:
                x = x.right

        z.parent = y

        if y == NIL:
            self.root = z
        elif z.value < y.value:
            y.left = z
        else:
            y.right = z

    def add(self, z: RedBlackNode):

        self.simple_insert(z)
        z.color = NTE.RED

        while z != self.root and z.parent.color == NTE.RED:

            if z.parent == z.parent.parent.left:

                y = z.parent.parent.right

                if y.color == NTE.RED:

                    z.parent.color = NTE.BLACK
                    y.color = NTE.BLACK
                    z.parent.parent.color = NTE.RED
                    z = z.parent.parent

                else:

                    if z == z.parent.right:
                        z = z.parent
                        self.rotate_left(z)
                    z.parent.color = NTE.BLACK
                    z.parent.parent.color = NTE.RED
                    self.rotate_right(z.parent.parent)

            else:

                y = z.parent.parent.left

                if y.color == NTE.RED:

                    z.parent.color = NTE.BLACK
                    y.color = NTE.BLACK
                    z.parent.parent.color = NTE.RED
                    z = z.parent.parent

                else:

                    if z == z.parent.left:
                        z = z.parent
                        self.rotate_right(z)

                    z.parent.color = NTE.BLACK
                    z.parent.parent.color = NTE.RED
                    self.rotate_left(z.parent.parent)

        self.root.color = NTE.BLACK

    def get_tree_values(self) -> List:

        result = [self.root.value]

        temp_left = self.root
        temp_right = self.root

        while temp_left:
            result.append(temp_left.value)
            temp_left = temp_left.left

        while temp_right:
            result.append(temp_right.value)
            temp_right = temp_right.right

        return result
