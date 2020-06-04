fn get_line<'a>(mut s: String) -> String {
    std::io::stdin().read_line(&mut s).unwrap();
    s.trim_end().to_owned()
}

fn kagami_mochi(mut dv: Vec<i32>) -> i32 {
    dv.sort();
    dv.into_iter().fold(vec![], |mut acc: Vec<i32>, x| {
        match acc.last() {
            Some(l) => {
                if *l != x {
                    acc.push(x);
                }
                acc
            }
            None => {
                acc.push(x);
                acc
            }
        }
    }).len() as i32

}

fn main() {
    let n: i32 = get_line(String::new()).parse().unwrap();
    let mut dv = vec![];
    {
        for _ in 0..n {
            dv.push(get_line(String::new()).parse().unwrap());
        }
    };

    println!("{}", kagami_mochi(dv));
}
