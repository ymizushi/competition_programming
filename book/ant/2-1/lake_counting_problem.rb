#!/usr/bin/env ruby
require 'minitest/autorun'


class Block
    attr_accessor :c, :before_block_list

    def initialize c
        @c = c
        @before_block_list = []
    end
end
#
class LakeCounter
    def initialize(c_list, x_num, y_num)
        @block_list = c_list.map do |c|
            Block.new(c)
        end
        @x_num = x_num
        @y_num = y_num
    end

    def get x, y
        index = @x_num * y + x
        if index >= @x_num*@y_num
            nil
        elsif x >= @x_num
            nil
        elsif y >= @y_num
            nil
        else
            @block_list[index]
        end
    end

    def mark x, y, before_block
        current_block = get(x, y)
        if current_block == nil
            return false
        end
        if current_block.c == nil
            return false
        end
        if current_block && current_block.c == 'W'
            current_block.before_block_list.push(before_block)
            true
        elsif mark(x-1, y-1, current_block)
        elsif mark(x, y-1, current_block)
        elsif mark(x+1, y-1, current_block)
        elsif mark(x-1, y,current_block )
        elsif mark(x+1, y, current_block)
        elsif mark(x-1, y+1, current_block)
        elsif mark(x, y+1, current_block)
        elsif mark(x+1, y+1, current_block)
        else
            false
        end
    end

    def count
        counter = 0
        for j in 0..@y_num-1 do
            for i in 0..@x_num-1 do
                if get(i, j) && mark(i, j, get(i,j))
                    counter += 1
                end
            end
        end
        counter
    end

end

class LakeCounerTest < MiniTest::Unit::TestCase
  def test_count
    c_list = [
        'W', nil, nil, nil, nil, nil, nil, nil, nil, 'W', 'W', nil,
        nil, 'W', 'W', 'W', nil, nil, nil, nil, nil, 'W', 'W', 'W',
    ]
    assert_equal 3, LakeCounter.new(c_list, 2, 12).count
  end
end

