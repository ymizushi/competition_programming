fn main() {
    println!("Hello, world!");
    let input: &std::vec::Vec<i32> = &vec![5, 2, 10, 8, 3 ,9];
    let result = bubble_sort(input);
}

fn bubble_sort(slice: &std::vec::Vec<i32>) -> &[i32] {
    for index in 0..slice.len() {
        let partial_slice = &mut slice[index .. slice.len()];
        array_loop(partial_slice);
    }
    return slice;
}

fn array_loop(slice: &mut[i32]) -> &mut[i32] {
    for index in 0..slice.len()-1 {
        let a = slice[index];
        let b = slice[index+1];
        let (after_a, after_b) = exchange(a, b);
        slice[index] = after_a;
        slice[index+1] = after_b;
    }
    return slice;
}

fn exchange(a: i32, b: i32) -> (i32, i32) {
    if a < b {
        return (a, b);
    } else {
        return (b, a);
    }
}
