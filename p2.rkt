#!/usr/bin/env racket
#lang racket

;(define (fib-slow n)
;  (cond 
;    [(= n 0) 1]
;    [(= n 1) 1]
;    [else
;      (+ (fib-slow (- n 2)) (fib-slow (- n 1)))]))
;(fib-slow 40)

(define (fib n)
  (define (fibl n n-2 n-1)
    (cond
      [(= n 0) n-1]
      [(> n 0) (fibl (- n 1) n-1 (+ n-2 n-1))]))
  (fibl n 0 1))
(fib 78)
