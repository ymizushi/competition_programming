fn get_line<'a>(mut s: String) -> String {
    std::io::stdin().read_line(&mut s).unwrap();
    s.trim_end().to_owned()
}

fn divide_vec(v: Vec<i32>, num: i32) -> (Vec<i32>, i32) {
    let v_len = v.len();
    let result = v.into_iter().filter(|e| e % 2 == 0).collect::<Vec<i32>>();
    if result.len() == v_len {
        divide_vec(result.into_iter().map(|e| e/2).collect::<Vec<i32>>(), num+1)
    } else {
        (result, num)
    }
}

fn main() {
    let n = {
        let s = get_line(String::new());
        let n: i32 = s.parse().unwrap();
        n
    };
    let mut input_num = vec![];
    {
        let s = get_line(String::new());
        let mut ws = s.split_whitespace(); 
        for _ in 0..n {
            input_num.push(ws.next().unwrap().parse().unwrap());
        }
    };

    let (_, num) = divide_vec(input_num, 0);

    println!("{}", num);
}
