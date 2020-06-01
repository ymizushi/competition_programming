fn get_line<'a>(mut s: String) -> String {
    std::io::stdin().read_line(&mut s).unwrap();
    s.trim_end().to_owned()
}

fn main() {
    let (a, b) = {
        let s= get_line(String::new());
        let mut ws = s.split_whitespace(); 
        let n: i32 = ws.next().unwrap().parse().unwrap();
        let m: i32 = ws.next().unwrap().parse().unwrap();
        (n, m)
    };
    let result = if a*b % 2 == 0 {
        "Even"
    } else {
        "Odd"
    };

    println!("{}", result);
}
