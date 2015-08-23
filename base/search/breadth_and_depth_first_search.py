#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Node(object):
    def __init__(self, value):
        self.value = value
        self.children = []

    def add_node(self, node):
        self.children += [node]

    def walk_by_depth(self, result):
        result += [self.value]
        if len(self.children) != 0:
            for child in self.children:
                child.walk_by_depth(result)
        return result

    def walk_by_breadth(self, queue, result):
        result += [self.value]
        for child in self.children:
            queue += [child]
        if len(queue) == 0:
            return result
        first = queue.pop(0)
        return first.walk_by_breadth(queue, result)

import unittest
class TestSearch(unittest.TestCase):
    def test_solve(self):
        node1 = Node(1)
        node2 = Node(2)
        node3 = Node(3)
        node4 = Node(4)
        node5 = Node(5)
        node2.add_node(node4)
        node2.add_node(node5)
        node1.add_node(node2)
        node1.add_node(node3)

        self.assertEqual(node1.walk_by_depth([]), [1 ,2 ,4 ,5 ,3])
        self.assertEqual(node1.walk_by_breadth([], []), [1 ,2 ,3 ,4 ,5])
        

if __name__ == '__main__':
    unittest.main()

