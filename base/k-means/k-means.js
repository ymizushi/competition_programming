var k_means;


class KMeans {
};

class Canvas {
  constructor(canvas) {
    this.canvas =  canvas;
  }

  draw() {
    if (!this.canvas || !this.canvas.getContext ) {
      return false;
    }
    var ctx = this.canvas.getContext('2d');
    ctx.beginPath();
    ctx.moveTo(20, 20);
    ctx.lineTo(120, 20);
    ctx.lineTo(120, 120);
    ctx.lineTo(20, 120);
    ctx.closePath();
    ctx.stroke();
  }
}

class Element {
  constructor(point, group) {
    this.point = point
    this.group = group;
  };
}

class Point {
  constructor(x, y){
    this.x = x;
    this.y = y;
  }
}


let choice = (array) => Math.floor(Math.random() * array.length);

let k_means_cluster(elements, groups) {

  let result = groups.map(
    group => elements.map(e => e.group == group).reduce((left, right) => [left.x + right.y, left.y+right.y])
  );

  result.map(point => )

  return result
}

window.onload = function() {
  canvas = new Canvas(document.getElementById('k-means'));
  canvas.draw();
  sample = [{"x": 10,"y": 20}, {"x": 10,"y": 20}, {"x": 10,"y": 20}, {"x": 10,"y": 20}]
  groups = ["A", "B", "C"];
  elements = sample.map(e => new Element(e["x"], e["y"], choice(groups)));
  group_a = elements.map(e => e.group == 'A');
  group_b = elements.map(e => e.group == 'B');
  group_c = elements.map(e => e.group == 'C');
  resuced_element = elements.reduce((left, right) => new Element(left.x + right.y, left.y+right.y, left.group));

  let x = resuced_element.x/elements.length; 
  let y = resuced_element.y/elements.length;
  console.log(x);
  console.log(y);
};
