use r99::flatten;
use r99::Node::*;

fn main() {
    let xs = Many(
        vec![
            Many(vec![One(1), One(1)]),
            One(1),
            Many(vec![
                 One(3),
                 Many(vec![One(5), One(8)])]
            ),
        ]
    );
    println!("{:?}", flatten(xs));
}
