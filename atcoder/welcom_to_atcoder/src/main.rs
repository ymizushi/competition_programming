fn get_line<'a>(mut s: String) -> String {
    std::io::stdin().read_line(&mut s).unwrap();
    s.trim_end().to_owned()
}

fn main() {
    let a = {
        let s= get_line(String::new());
        let mut ws = s.split_whitespace(); // 空白区切りの単語に分解する
        let n: i32 = ws.next().unwrap().parse().unwrap(); // イテレータから値を取り出して整数に
        n
    };
    let (b, c) = {
        let s= get_line(String::new());
        let mut ws = s.split_whitespace(); // 空白区切りの単語に分解する
        let n: i32 = ws.next().unwrap().parse().unwrap(); // イテレータから値を取り出して整数に
        let m: i32 = ws.next().unwrap().parse().unwrap(); // イテレータから値を取り出して整数に
        (n, m)
    };
    let word = {
        get_line(String::new())
    };
    println!("{} {}", a+b+c, word);
}
