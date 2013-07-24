#!/usr/bin/env python
# -*- coding: utf-8 -*-

ROW = 10
COLUMN = 10

class Tile:
    def __init__(self,kind,x,y):
        self.kind = kind
        self.before_tile = None
        self.searched = False
        self.x = x
        self.y = y
 
tile_list = []

tile_que = []

tile_map = [
["#","S","#","#","#","#","#","#",".","#"],
[".",".",".",".",".",".","#",".",".","#"],
[".","#",".","#","#",".","#","#",".","#"],
[".","#",".",".",".",".",".",".",".","."],
["#","#",".","#","#",".","#","#","#","#"],
[".",".",".",".","#",".",".",".",".","#"],
[".","#","#","#","#","#","#","#",".","#"],
[".",".",".",".","#",".",".",".",".","."],
[".","#","#","#","#",".","#","#","#","."],
[".",".",".",".","#",".",".",".","G","#"],
]

for y in range(COLUMN):
    for x in range(ROW):
        tile_list += [Tile(tile_map[y][x],x,y)]

def get_tile_by_x_y(x, y):
    if x<0 or y < 0:
        return None
    if x >= ROW or y >= COLUMN:
        return None
    return tile_list[y*ROW + x]
 
def check(x,y):
    if x<0 or y < 0:
        return False
    if x >= ROW or y >= COLUMN:
        return False
    tile = get_tile_by_x_y(x,y)
    if tile.searched:
        return False
    if tile.kind is "#":
        return False
    return True
 
def surround_tiles(tile):
    tiles = []
    if check(tile.x,tile.y-1):
        tile = get_tile_by_x_y(tile.x,tile.y-1)
        tiles += [tile]
    if check(tile.x+1,tile.y):
        tile = get_tile_by_x_y(tile.x+1,tile.y)
        tiles += [tile]
    if check(tile.x,tile.y+1):
        tile = get_tile_by_x_y(tile.x,tile.y+1)
        tiles += [tile]
    if check(tile.x-1,tile.y):
        tile = get_tile_by_x_y(tile.x-1,tile.y)
        tiles += [tile]
    return tiles

start_tile = filter(lambda x:x.kind == "S", tile_list)

tile_que += [start_tile[0]]
 
def choice_tile(tile_que,count):
    tile = tile_que.pop(0)
    tile.searched = True
    if tile.kind == "G":
        return tile,count
    tiles = surround_tiles(tile)
    tile_que += tiles
    if tile_que:
        return choice_tile(tile_que,count+1)
    raise Exception("not found")
 
tile,count = choice_tile(tile_que,0)
print tile.x
print tile.y
print count
