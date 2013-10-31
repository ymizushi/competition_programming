#!/usr/bin/env racket
#lang racket

(define (prime? n)
  (cond 
    [(< n 3) false]
    [(>= n 3) 
      (filter (lambda (x) (/ x n) (range n)))
     ]))
