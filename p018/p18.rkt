#!/usr/bin/env racket
#lang racket
(require test-engine/racket-tests)

(define triangle-num
  (list (list 75)
        (list 95 64)
        (list 17 47 82)
        (list 18 35 87 10)
        (list 20 04 82 47 65)
        (list 19 01 23 75 03 34)
        (list 88 02 77 73 07 63 67)
        (list 99 65 04 28 06 16 70 92)
        (list 41 41 26 56 83 40 80 70 33)
        (list 41 48 72 33 47 32 37 16 94 29)
        (list 53 71 44 65 25 43 91 52 97 51 14)
        (list 70 11 33 28 77 73 17 78 39 68 17 57)
        (list 91 71 52 38 17 14 91 43 58 50 27 29 48)
        (list 63 66 04 68 89 53 67 30 73 16 69 87 40 31)
        (list 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23)))

(define (next-num-list r c)
  (let ([row-length (length triangle-num)] [next-row-index (add1 r)])
    (if (< next-row-index row-length)
      (let ([next-row-list (list-ref triangle-num next-row-index)])
        (list
          (list next-row-index c (list-ref next-row-list c))
          (list next-row-index (add1 c) (list-ref next-row-list (add1 c)))))
      null)))

(define (next-num r c)
  (let* ([next-num-lists (next-num-list r c)]
         [next-num-first (first next-num-lists)]
         [next-num-last (last next-num-lists)])
    (if (< (list-ref next-num-first 2) (list-ref next-num-last 2))
      next-num-last
      next-num-first)))

(define (route-max-triangle-num [sum 75] [now (next-num 0 0)])
  (let ([hoge (displayln (list-ref now 2))]) (if (= (list-ref now 0) 14)
    (+ sum (list-ref now 2))
    (route-max-triangle-num (+ sum (list-ref now 2)) (next-num (list-ref now 0) (list-ref now 1))))))

(check-expect (next-num-list 0 0) (list `(1 0 95) `(1 1 64)))
(check-expect (next-num-list 13 0) (list `(14 0 04) `(14 1 62)))
(check-expect (next-num 0 0) `(1 0 95))
(check-expect (next-num 1 0) `(2 1 47))
(check-expect (next-num 2 1) `(3 2 87))
(check-expect (next-num 3 2) `(4 2 82))
(check-expect (next-num 4 2) `(5 3 75))
(check-expect (next-num 13 0) `(14 1 62))
(check-expect (next-num 13 7) `(14 7 98))
(check-expect (route-max-triangle-num) 1064)

(test)
