var http = require('http');
http.createServer(function (req, res) {
    if (req.method == 'GET') {
      res.writeHead(200, {'Content-Type': 'text/html'});
      res.end('<!DOCTYPE html><html><head></head><body><h1>Success</h1></body></html>\n');  
    } else {
      res.writeHead(405, {'Allow': 'GET'});
      res.end('\n');
    }
}).listen(8080, 'localhost');
console.log('Server running at http://localhost:8080');
