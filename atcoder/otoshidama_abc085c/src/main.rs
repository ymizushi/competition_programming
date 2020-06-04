fn get_line<'a>(mut s: String) -> String {
    std::io::stdin().read_line(&mut s).unwrap();
    s.trim_end().to_owned()
}

fn otoshidama(n: i32, m: i32) -> (i32, i32, i32) {
    for a in 0..n+1 {
        for b in 0..n-a+1 {
            for c in 0..n-a-b+1 {
                if a+b+c == n && a * 10000 + b * 5000 + c * 1000 == m {
                    return  (a, b, c)
                }
            }
        }
    }
    (-1, -1, -1)
}


fn main() {
    let line = get_line(String::new());
    let mut ws = line.split_whitespace(); 
    let n = ws.next().unwrap().parse().unwrap();
    let y = ws.next().unwrap().parse().unwrap();

    let (x, y, z) = otoshidama(n, y);
    println!("{} {} {}", x, y, z);
}
