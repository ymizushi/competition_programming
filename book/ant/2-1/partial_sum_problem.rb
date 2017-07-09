#!/usr/bin/env ruby
require 'minitest/autorun'
#
class PartialSumSolver
    def initialize target_list, k 
        @target_list = target_list
        @k = k
    end

    def solve
        recursive_solve(0, 0, @target_list, @k)
    end

    def recursive_solve index, sum, target_list, k
        num = target_list[index]
        if num+sum == k then
            true
        elsif target_list.length == (index+1) then
            false
        elsif recursive_solve(index+1, sum+num, target_list, k) then
            true
        elsif recursive_solve(index+1, sum, target_list, k) then
            true
        else
            false
        end
    end
end

class TestSolver1 < MiniTest::Unit::TestCase
  def test_solve

    assert_equal true, PartialSumSolver.new([1,2,4,7], 13).solve
    assert_equal false, PartialSumSolver.new([1,2,4,7], 15).solve
  end
end
