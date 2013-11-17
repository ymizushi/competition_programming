#!/usr/bin/env racket
#lang racket
(require test-engine/racket-tests)


(define (max-pal)
  (let loop-n ([n 989])
    (let loop-x ([x 999])
      (let* ([s-n (number->string n)]
             [target (string->number
                       (string-append
                         s-n
                         (list->string (reverse (string->list s-n)))))]
             [y (/ target x)])
        (if (and
              (= 0 (remainder target x))
              (= 3 (length (string->list (number->string y)))))
          target
          (cond
            [(not (= x 100)) (loop-x (- x 1))]
            [(not (= n 100)) (loop-n (- n 1))]
            [else null]))))))

(check-expect (max-pal) 906609)
(test)
