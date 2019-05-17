"""

Task 1: Write a simple Higher Order Function map(data, f),
where f() is some arith function and data is a List, Dictionary and Numpy array.
map(data, f) applies function f() to every element of the data structure and returns a resulting data structure.

Can you make a single implementation, Overloaded for all those 3 data structures? Assume datatype is Int.
Which algorithmic complexity O(n) should it be? Will it depend on the underlying data structure?


Task 2: Implement a speed optimized function for Task 1, the fastest you can.
What algorithmic complexity O(n) should it be ?

"""

import numpy as np


class SimpleTask:

    def map_impl(self, data, f):
        """
        Реализация функции map

        неоптимальный вариант:

          def map_impl(self, data, f):

              result = []

              for index, item in enumerate(data):
                  result.append(f(item))

              return result

        """

        for index, item in enumerate(data):
            yield f(item)


if __name__ == "__main__":

    simple_tasks = SimpleTask()

    test_list = [4, 8, 15, 16, 23, 42]

    print(f"Пример для list: {list(simple_tasks.map_impl(data=test_list, f=lambda item: item ** 2))}")
    print(" ")

    test_dict = {
        "a": 1,
        "b": 2,
        "c": 3,
        "d": 4
    }

    print(f'Пример для dict: {list(simple_tasks.map_impl(test_dict.items(), lambda item: (item[0], item[1] + 10)))}')

    test_numpy = np.arange(10)

    print(f'Пример для numpy: {list(simple_tasks.map_impl(test_numpy, lambda item: item / 2))}')
