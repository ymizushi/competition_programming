#!/usr/bin/env ruby
require 'minitest/autorun'
#
class Solver1
    def self.solve(target_list, k)
        self.local_solve(0,0, target_list, k)
    end

    def self.local_solve index, sum, target_list, k
        num = target_list[index]
        if num+sum == k then
            true
        elsif target_list.length == index+1 then
            false
        elsif local_solve(index + 1, sum+num, target_list, k) then
            true
        elsif local_solve(index + 1, sum, target_list, k) then
            true
        else
            false
        end
    end
end

class TestSolver1 < MiniTest::Unit::TestCase
  def test_solve
    assert_equal true, Solver1.solve([1,2,10], 13)
    assert_equal false, Solver1.solve([1,2,11], 15)
  end
end
