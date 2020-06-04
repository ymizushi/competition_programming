fn get_line<'a>(mut s: String) -> String {
    std::io::stdin().read_line(&mut s).unwrap();
    s.trim_end().to_owned()
}

fn patterns(a: i32, b: i32, c: i32, x: i32) -> i32 {
    let mut all_patterns = vec![];
    for ai in 0..a+1 {
        for bi in 0..b+1 {
            for ci in 0..c+1 {
                all_patterns.push((ai, bi, ci))
            }
        }
    };
    all_patterns.into_iter().filter(|(a, b, c)| 500*a + 100*b + 50*c == x).collect::<Vec<(i32, i32, i32)>>().len() as i32
}

fn main() {
    let a = {
        let s = get_line(String::new());
        let a: i32 = s.parse().unwrap();
        a
    };
    let b = {
        let s = get_line(String::new());
        let b: i32 = s.parse().unwrap();
        b
    };
    let c = {
        let s = get_line(String::new());
        let c: i32 = s.parse().unwrap();
        c
    };
    let x = {
        let s = get_line(String::new());
        let x: i32 = s.parse().unwrap();
        x
    };

    let num = patterns(a, b, c, x);

    println!("{}\n", num);
}
