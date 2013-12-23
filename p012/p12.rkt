#!/usr/bin/env racket
#lang racket
(require test-engine/racket-tests)

(define (nth-tri-num n)
  (let loop ([i 1] [sum 0])
    (if (i . > . n)
      sum
      (loop (add1 i) (+ i sum)))))

(define (count-factor n)
  (let loop ([i 1] [count 0])
    (if (> i n)
      count
      (if (= (remainder n i) 0)
        (loop (add1 i) (add1 count))
        (loop (add1 i) count)))))

(define (have-n-divisors n)
  (let loop ([i 0])
    (if (<= n (count-factor (nth-tri-num i)))
      (nth-tri-num i)
      (loop (add1 i))))) 

(check-expect (nth-tri-num 1) 1)
(check-expect (nth-tri-num 2) 3)
(check-expect (nth-tri-num 3) 6)
(check-expect (nth-tri-num 4) 10)

(check-expect (count-factor 1) 1)
(check-expect (count-factor 2) 2)
(check-expect (count-factor 3) 2)
(check-expect (count-factor 4) 3)
(check-expect (count-factor 6) 4)
(check-expect (count-factor 10) 4)

(check-expect (have-n-divisors 4) 6)
(check-expect (have-n-divisors 50) 25200)

(test)
