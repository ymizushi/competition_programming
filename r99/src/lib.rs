pub fn last<E>(e: &Vec<E>) -> E where E: Copy {
    e.last().unwrap().clone()
}

pub fn penumerate<E>(v: &Vec<E>)  -> E where E: Copy {
    let len = v.len();
    v[len-2]
}

pub fn nth<T>(v: &Vec<T>, i: usize) -> T where T: Copy {
    v[i]
}

pub fn length<T>(v: &Vec<T>) -> usize where T: Copy {
    v.len()
}

pub fn reverse<T>(v: &mut Vec<T>) -> &Vec<T> {
    v.reverse();
    v
}

pub fn pallndrome<T>(v: Vec<T>) -> bool where T: PartialEq {
    let len = v.len();
    let end_index = len-1;
    for i in 0..end_index {
        if v[i] != v[end_index-i] {
            return false
        }
    }
    true
}


#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn p01_last() {
        let v = vec![1,1,2,3,6,5];
        assert_eq!(5, last(&v));
    }

    #[test]
    fn p02_penumerate() {
        let v = vec![1,1,2,3,6,5];
        assert_eq!(6, penumerate(&v));
    }

    #[test]
    fn p03_nth() {
        let v = vec![1,1,2,3,6,5];
        assert_eq!(1, nth(&v, 0));
        assert_eq!(1, nth(&v, 1));
        assert_eq!(5, nth(&v, 5));
    }

    #[test]
    #[should_panic]
    fn p03_nth_failed() {
        let v = vec![1,1,2,3,6,5];
        assert_eq!(1, nth(&v, 6));
    }

    #[test]
    fn p04_length() {
        let v = vec![1,1,2,3,6,5];
        assert_eq!(6, length(&v));
    }

    #[test]
    fn p05_reverse() {
        let mut v = vec![1,1,2,3,6,5];
        assert_eq!(&vec![5, 6, 3, 2, 1, 1], reverse(&mut v));
    }

    #[test]
    fn p06_pallndrome() {
        assert!(pallndrome(vec![1,2,3,2,1]));
        assert!(!pallndrome(vec![1,3,3,2,1]));
    }
}
