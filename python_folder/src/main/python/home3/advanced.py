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

from optional import Optional

import random

from home3.binary_tree import BinaryTree
from home3.red_black_tree import Tree, RedBlackNode


class HigherOrderFunctions:

    def map(self, value) -> Optional:

        return Optional.of(value)

    def flat_map(self, value: Optional):

        return value.get()

    def with_filter(self, data, f):

        for index, item in enumerate(data):
            if f(item):
                yield item


if __name__ == "__main__":

    hof = HigherOrderFunctions()

    test_values = [random.randint(1, 1001) for i in range(1000)]

    binary_tree = BinaryTree(random.randint(1, 1001))

    for item in test_values:
        binary_tree.add(item)

    binary_result = binary_tree.get_tree_values()

    print(f"Результат для бинарного дерева #1: "
          f"{sum(hof.flat_map(hof.map(hof.with_filter(binary_result, lambda x: x % 2 == 0))))}")
    print(f"Результат для бинарного дерева #2: "
          f"{sum(hof.flat_map(hof.map(hof.with_filter(binary_result, lambda x: (x % 3 == 0) and (x % 5 == 0)))))}")
    print(" ")

    red_black_tree = Tree()

    for item in test_values:
        red_black_tree.add(RedBlackNode(item))

    red_black_result = red_black_tree.get_tree_values()

    print(f"Результат для красно-чёрного дерева #1: "
          f"{sum(hof.flat_map(hof.map(hof.with_filter(red_black_result, lambda x: x % 2 == 0))))}")
    print(f"Результат для красно-чёрного  дерева #2: "
          f"{sum(hof.flat_map(hof.map(hof.with_filter(red_black_result, lambda x: (x % 3 == 0) and (x % 5 == 0)))))}")
    print(" ")
