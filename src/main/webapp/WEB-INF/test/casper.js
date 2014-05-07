var casper = require('casper').create();

casper.start('http://127.0.0.1:8080/report/', function() {
   this.echo(this.getTitle());
});

casper.thenOpen('http://phantomjs.org', function() {
    this.echo(this.getTitle());
});

casper.run();