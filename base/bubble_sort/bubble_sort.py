#!/usr/bin/env python

def bubble_sort(array):
    while(True):
        swapped = False
        for index,value in enumerate(array):
            if len(array) <= index+1:
                continue
            if array[index] <= array[index+1]:
                continue
            else:
                swap(array, index, index+1)
                swapped = True
        if swapped:
            pass
        else:
            return array

def swap(array, start, end):
    tmp_start = array[start]
    tmp_end = array[end]
    array[start] = tmp_end
    array[end] = tmp_start
    return array

print (bubble_sort([3,1,2,5, 100, 20 ,3,10 ,3, 234 ,5]))
