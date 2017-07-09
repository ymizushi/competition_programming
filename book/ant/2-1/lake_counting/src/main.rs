pub fn partial_sum(index: usize, sum: i32, target_list: &[i32], k: i32) -> bool {
    let target = target_list[index];
    if target+sum == k {
        return true;
    } else if target_list.len() == (index+1) {
        return false;
    } else if partial_sum(index+1, sum+target, target_list, k) {
        return true;
    } else if partial_sum(index+1, sum, target_list, k) {
        return true;
    } else {
        return false;
    }
}

#[cfg(test)]
mod tests {
    use super::partial_sum;
    #[test]

    fn assert_partial_sum() {
        assert_eq!(true, partial_sum(0, 0, &[1, 2, 4, 7], 13));
        assert_eq!(false, partial_sum(0, 0, &[1, 2, 4, 7], 15));
    }
}
