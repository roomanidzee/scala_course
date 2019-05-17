"""

Task 1: Implement higher order functions map(), flatMap() and withFiler() for Option(Int).
It wraps Int in a class. Each value may be either Int or Null

flatMap() differs from map(), since it provides data flattening.
For example, if you apply map() twice to your data structure,
your result should be map(map(Option(Int))) -> Option(Option(Int)), whereas flatMap(flatMap(Option[Int])) -> Option(Int)

withFiler() is a Higher Order Function, which takes a function on input and applies it as a filter to every element

Task 2: Given an implementation from Task1, build a 1000 element

A. Unsorted binary tree.
B. Red-black tree

and calculate the sum of all nodes for Option(Int). Your filtering functions should be:

A. a % 2 == 0 (even numbers)
B. (a % 3 == 0) && (a % 5 == 0) (divisible by 3 and 5)

Использую библиотеку optional.py для корректной работы с optional

"""
from typing import List

from optional import Optional


class HigherOrderFunctions:

    def map(self, value) -> Optional:

        return Optional.of(value)

    def flat_map(self, value: Optional):

        return value.get()

    def with_filter(self, data, f):

        for index, item in enumerate(data):
            if f(item):
                yield item


# реализация деревьев

class Node:

    def __init__(self, value):
        self.left = None
        self.right = None
        self.value = value

    def __str__(self):

        print(f"Node(value = {self.value}, left = {self.left}, right = {self.right})")


class BinaryTree:

    def __init__(self, root):
        self.root = Node(root)

    def _insert(self, node: Node, value):

        if value < node.value:

            if not node.left:
                node.left = Node(value)
            else:
                self._insert(node.left, value)

        else:

            if not node.right:
                node.right = Node(value)
            else:
                self._insert(node.right, value)

    def add(self, value):

        if not self.root.value:
            self.root.value = value
        else:
            self._insert(self.root, value)

    def __str__(self):

        print(f"BinaryTree(root = {self.root}, left = {self.root.left}, right = {self.root.right})")

    def get_nodes_values(self) -> List:
        return self.get_node_value(self.root)

    def get_node_value(self, node: Node) -> List:

        result = [node.value]

        result.extend(self.get_node_value(node.left))
        result.extend(self.get_node_value(node.right))

        return result

# доделаю красно - чёрное дерево
if __name__ == "__main__":

   pass
