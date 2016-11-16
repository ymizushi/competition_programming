var k_means;


class KMeans {
};

class Canvas {
  constructor(canvas) {
    this.canvas =  canvas;
  }

  draw(point, color) {
    if (!this.canvas || !this.canvas.getContext ) {
      return false;
    }
    var ctx = this.canvas.getContext('2d');
    if (color) {
      ctx.fillStyle = color;
    }
    ctx.fillRect(point.x, point.y, 5, 5);
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


let choice = (array) => array[Math.floor(Math.random() * array.length)];

let k_means_cluster = (elements, groups) => {
  let average_cluster = groups.map(
  group => {let result = elements.filter(e => e.group == group).reduce((left, right) => {return new Element(new Point(left.point.x + right.point.x, left.point.y + right.point.y), group)}, new Element(new Point(0, 0), group)); result.poin}
);
  average_cluster.point.x = average_cluster.
  reassign_count = 0;

  for (cluster of average_cluster) {
    canvas.draw(new Point(), 'rgb(200, 0, 0)');
  }
  console.log(average_cluster)

  for (var element of elements) {
    var min_distance = 1000000; // MEMO: ある程度大きい値
    var min_group = element.group;
    for (var current_cluster of average_cluster) {
      var diff_x = (element.point.x - current_cluster.point.x);
      var diff_y = (element.point.y - current_cluster.point.y);
      current_distance = diff_x * diff_x + diff_y * diff_y
      if (current_distance < min_distance) {
        min_distance = current_distance;
        min_group = current_cluster.group;
      }
    }
    if (element.group != min_group) {
      element.group = min_group;
      reassign_count++;
    }
  }

  return [elements, reassign_count, ]
}

window.onload = function() {
  canvas = new Canvas(document.getElementById('k-means'));
  sample = [{"x": 15,"y": 100}, {"x": 99,"y": 10}, {"x": 20,"y": 105}, {"x": 21,"y": 106}, {"x": 16, "y": 101}, {"x": 105, "y": 11}, {"x": 20, "y": 100}, {"x": 104,"y": 100}, {"x": 19,"y": 100}, {"x": 20,"y": 30}, {"x": 50, "y": 100}, {"x": 100, "y": 100}, {"x": 80,"y": 40}, {"x": 100,"y": 80}, {"x": 114,"y": 61}, {"x": 12,"y": 5}, {"x": 101, "y": 100}, {"x": 110, "y": 91}]
  groups = ["A", "B", "C"];
  elements = sample.map((e, index) => new Element(new Point(e["x"], e["y"]), groups[index % groups.length]));
  let result = k_means_cluster(elements, groups);
  for (e of elements) {
    canvas.draw(e.point, 'rgb(0, 200, 0');
  }
  result = k_means_cluster(result[0], groups);
  result = k_means_cluster(result[0], groups);
  result = k_means_cluster(result[0], groups);
  result = k_means_cluster(result[0], groups);
  result = k_means_cluster(result[0], groups);
  result = k_means_cluster(result[0], groups);
  result = k_means_cluster(result[0], groups);
  result = k_means_cluster(result[0], groups);
  result = k_means_cluster(result[0], groups);
  result = k_means_cluster(result[0], groups);
  result = k_means_cluster(result[0], groups);
  result = k_means_cluster(result[0], groups);
  result = k_means_cluster(result[0], groups);
  result = k_means_cluster(result[0], groups);
  result = k_means_cluster(result[0], groups);
  result = k_means_cluster(result[0], groups);
  result = k_means_cluster(result[0], groups);
  result = k_means_cluster(result[0], groups);
  result = k_means_cluster(result[0], groups);
};
