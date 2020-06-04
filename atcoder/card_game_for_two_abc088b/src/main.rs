fn get_line<'a>(mut s: String) -> String {
    std::io::stdin().read_line(&mut s).unwrap();
    s.trim_end().to_owned()
}

fn card_game_for_two(mut av: Vec<i32>) -> i32 {
    av.sort();
    av.reverse();
    let alice_sum:i32 = av.iter().enumerate().filter(|(i, _)| i % 2 == 0).map(|(_, v)| v).sum();
    let bob_sum:i32 = av.iter().enumerate().filter(|(i, _)| i % 2 == 1).map(|(_, v)| v).sum();
    alice_sum - bob_sum
}

fn main() {
    let _: i32 = get_line(String::new()).parse().unwrap();
    let mut av = vec![];
    {
        let s = get_line(String::new());
        for ws in s.split_whitespace() {
            av.push(ws.parse().unwrap());
        }
    };

    println!("{}", card_game_for_two(av));
}
