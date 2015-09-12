#!/usr/bin/env ruby
#
#
def swap(a, b)
    if (a.ord > b.ord) then
        [b, a]
    else 
        [a, b]
    end
end

# def merge(top, rest)
#     split_index = top.length / 2
#     if split_index <= 2 then
#         left =  swap(top[0], top[1])
#     else
#         left  = merge(top.slice(0, split_index), top.slice(split_index, top.length))
#     end
# 
#     split_index = rest.length / 2
#     if split_index <= 2 then
#         return swap(rest[0], rest[1])
#     else
#         right  = merge(rest.slice(0, split_index), rest.slice(split_index, rest.length))
#     end
#     merge(left, right)
# end
# 
# def mmerge(list)
#     split_index = list.length/2
#     merge(list.slice(0, split_index), list.slice(split_index, list.length))
# end
# 
# print mmerge([1,2,3,4,5])


def merge(sorted_left, sorted_right)
    merged_list = []
    left_index = 0
    right_index = 0
    while left_index ==  do
        if sorted_left[left_index] < sorted_right[right_index] then
            merged_list.push(sorted_left[left_index])
            left_index += 1
        else
            merged_list.push(sorted_right[right_index])
            right_index += 1
        end
    end


end
