def integer_string?(str)
    Integer(str)
    true
rescue ArgumentError
    false
end

class State
    attr_reader :state
    def initialize(state)
        @state = state
    end

    def input(c)
        if integer_string?(c) then
            [nil, Number.new(c)]
        elsif c == "+"
            raise "最初に+は続けられません"
        elsif c == "-"
            [nil, Minus.new("-")]
        elsif c == " "
            [nil, Space.new(" ")]
        end
    end
end

class Plus < State
    def input(c)
        if integer_string?(c) then
            [self, Number.new(c)]
        elsif c == "+"
            raise "+は２回続けられません"
        elsif c == "-"
            raise "+の次に-は続けられません"
        elsif c == " "
            [nil, self]
        end
    end
end

class Minus < State
    def input(c)
        if integer_string?(c) then
            [self, Number.new(c)]
        elsif c == "+"
            raise "+の次に-は続けられません"
        elsif c == "-"
            raise "-は２回続けられません"
        elsif c == " "
            [nil, self]
        end
    end
end

class Space < State
    def input(c)
        if integer_string?(c) then
            [self, Number.new(c)]
        elsif c == "+"
            [self, Plus.new("+")]
        elsif c == "-"
            [self, Minus.new("-")]
        elsif c == " "
            [nil, self]
        end
    end
end


class Number < State
    def input(c)
        if integer_string?(c) then
            @state << c
            [nil, self]
        elsif c == "+"
            [self, Plus.new("+")]
        elsif c == "-"
            [self, Minus.new("-")]
        elsif c == " "
            [self, Space.new(" ")]
        end
    end
end

class Node 
end

class PlusNode < Node
    attr_reader :children
    def initialize
        @children = []
    end

    def add(node)
        @children.push(node)
    end

    def evalu
        @children.map {|child|
            child.evalu
        }.inject(:+)
    end
end

class NumberNode < Node
    attr_reader :value
    def initialize(value)
        @value = value
    end

    def evalu
        @value.to_i
    end
end

sample = "33 +   2222 + 3 + 2222 + 22222"
next_state = State.new("")
output_list = []
sample.each_char do |c|
    result = next_state.input(c)
    state = result[0]
    next_state = result[1]
    if state
        output_list.push(state)
    end
end
output_list.push(next_state)

abstract_syntax_tree = nil
output_list.each do |output|
    p output.state
end


sample_node = PlusNode.new()
sample_node.add(NumberNode.new("2"))
sample_node.add(NumberNode.new("3"))
p sample_node.evalu
