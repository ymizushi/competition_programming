#!/usr/bin/env ruby
require 'minitest/autorun'
#
class Block
    attr_accessor :group_number

    def filled?
        return @is_filled
    end

    def initialize(is_filled, group_number)
        @is_filled = is_filled
        @group_number = group_number
    end
end


class LakeCountingSolver
    def initialize(width, height)
        for i in 0..width
        end
        @blocks = new 
    end

    def solve
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

