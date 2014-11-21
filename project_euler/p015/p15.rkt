#!/usr/bin/env racket
#lang racket
(require test-engine/racket-tests)

;(define result-hash
;  (make-hash))
;
;(define (route-num x y)
;  (let* ([key (string-append x "-" y)]
;         [value (hash-ref result-hash key null)])
;    (if value
;      value
;      (if (or (< x 0) (< y 0))
;        1
;        (let (loop-x [x 0])
;          (let (loop-y [y 0]))
;            (if (< y 20)
;              (hash-set! (loop-y (+ y 1)))
;              )
;          
;          )
;        
;        
;        ))))
;
;(check-expect (route-num 1 1) 6)
;(check-expect (route-num 5 5) 6)
(test)
