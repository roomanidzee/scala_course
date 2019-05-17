from typing import List


class BinaryNode:

    def __init__(self, value):
        self.left = None
        self.right = None
        self.value = value

    def __str__(self):

        print(f"BinaryNode(value = {self.value}, left = {self.left}, right = {self.right})")


class BinaryTree:

    def __init__(self, root):
        self.root = BinaryNode(root)

    def _insert(self, node: BinaryNode, value):

        if value < node.value:

            if not node.left:
                node.left = BinaryNode(value)
            else:
                self._insert(node.left, value)

        else:

            if not node.right:
                node.right = BinaryNode(value)
            else:
                self._insert(node.right, value)

    def add(self, value):

        if not self.root.value:
            self.root.value = value
        else:
            self._insert(self.root, value)

    def __str__(self):

        print(f"BinaryTree(root = {self.root}, left = {self.root.left}, right = {self.root.right})")

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
