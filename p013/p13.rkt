#!/usr/bin/env racket
#lang racket
(require test-engine/racket-tests)

(define current-dir
  (path->string (build-path (current-directory))))

(define test-file
  (string-append current-dir "p13.txt"))

(define (sum-line lst [sum 0])
  (if (empty? lst)
    sum
    (sum-line (rest lst) (+ (first lst) sum))))

(check-expect (sum-line (list 1000 2000 3000 4000)) 10000)

(define (first-ten-digits input) 
  (string->number (substring (number->string (sum-line input))
    0
    10)))

(check-expect (first-ten-digits (map (lambda (x) (string->number x)) (file->lines test-file))) 5537376230)

(check-expect (+ 1 1) 2)
(test)
