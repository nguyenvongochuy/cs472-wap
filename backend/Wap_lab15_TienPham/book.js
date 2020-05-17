(function($, utils) {
  const App = {
    init: function() {
      this.tableView = $('#tableView');
      this.headerTemplate = $('#headerTemplate');
      this.itemTemplate = $('#itemTemplate');
      this.loadData();
    },
    loadData: function () {
      const myRequest = new Request('https://elibraryrestapi.herokuapp.com/elibrary/api/book/list', {
        method: 'GET',
        headers: new Headers(),
        mode: 'cors',
        cache: 'default'
      });
      fetch(myRequest)
      .then(response => response.json())
      .then(books => this.renderTableView(books.sort((b1, b2) => b1.bookId - b2.bookId)));
    },
    renderTableView(books) {
      //clear
      this.tableView.html('');
      // render header
      this.tableView.loadTemplate(this.headerTemplate);
      //render item data
      for (let index = 0; index < books.length; index++) {
        const item = books[index];
        this.tableView.loadTemplate(this.itemTemplate, item, { append: true });
      }
    }
  }
  App.init();
  utils.display();
})(jQuery, UTILS);
