class BinaryTree
    attr_accessor :left, :right

    def initialize num
        @num = num
        @left = nil
        @right = nil
    end

    def add(num)
        bt = BinaryTree.new(num)
        if @num < num
            @right = bt
        else
            @left = bt
        end
    end

    def search(num)
        if @num == num
            self
        elsif !@right.nil? && @num < num
            @right.search(num)
        elsif !@left.nil? && @num > num
            @left.search(num)
        else
            nil
        end
    end
end


root = BinaryTree.new(20)

root.add(15)
root.add(5)
root.add(6)
root.add(20)
root.add(100)

p root.search(100)
