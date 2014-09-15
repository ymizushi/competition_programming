-module(p1).
-export([start/0]).
-export([fib/1]).

start() ->
  io:format("~p~n", [fib(10)]).

fib(N) when N =:= 0 ->
    1;
fib(N) when N =:= 1 ->
    1;
fib(N) when 2 =< N ->
    fib(N-2) + fib(N-1).
