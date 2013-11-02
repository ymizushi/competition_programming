#!/usr/bin/env racket
#lang racket

(define (prime? n)
  (cond 
    [(= n 1) false]
    [(= n 2) true ]
    [(= n 2) true ]
    [else 
      (let loop ([cnt 2])
        (if (= (% n cnt) 0)
          false
          (if (<= (int (cnt math->sqrt)))
            false
            (loop (+ cnt 1)))))]))
