fn get_line<'a>(mut s: String) -> String {
    std::io::stdin().read_line(&mut s).unwrap();
    s.trim_end().to_owned()
}

fn some_sums(n: i32, a: i32, b: i32) -> i32 {
    (0..n+1).filter(|x| {
        let mut sum = 0;
        for c in x.to_string().chars() {
            sum += c as i32 - 48;
        }
        a <= sum && sum <= b 
    }).sum()
}

fn main() {
    let (n, a, b) = {
        let s= get_line(String::new());
        let mut ws = s.split_whitespace(); 
        let n: i32 = ws.next().unwrap().parse().unwrap();
        let a: i32 = ws.next().unwrap().parse().unwrap();
        let b: i32 = ws.next().unwrap().parse().unwrap();
        (n, a, b)
    };

    println!("{}", some_sums(n, a, b));
}
