#!/usr/bin/env racket
#lang racket
(require test-engine/racket-tests)

(define (fac n [result 1])
  (if (= n 1)
    result
    (fac (- n 1) (* result n))))

(define (sum-str-fac n)
  (let ([result (fac n)])
    (apply + (map (lambda (x) (string->number x)) (string->list (number->string result))))))

(check-expect (fac 1) 1)
(check-expect (fac 2) 2)
(check-expect (fac 3) 6)
(check-expect (fac 4) 24)
(check-expect (fac 10) 3628800)
(check-expect (sum-str-fac 10) 363)
(test)
