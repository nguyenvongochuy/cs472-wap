(function($) {
  const App = {
    init: function() {
      this.form = $('#form');
      this.buttonReset = $('#btnReset');

      this.bindEvents();
    },
    bindEvents() {
      this.form.on('submit', this.saveBook.bind(this));
      this.buttonReset.on('click', this.clearForm.bind(this));
    },
    saveBook(evt) {
      evt.preventDefault();

      const data = {
        // bookId: Date.now(),
        isbn: this.form.find('#isbn').val(),
        title: this.form.find('#bookTitle').val(),
        overdueFee: this.form.find('#overdueFee').val(),
        publisher: this.form.find('#publisher').val(),
        datePublished: new Date(this.form.find('#datePublished').val())
      };

      const headers = new Headers();
      headers.append('Content-Type', 'application/json')
      const myRequest = new Request('https://elibraryrestapi.herokuapp.com/elibrary/api/book/add', {
        method: 'POST',
        headers,
        mode: 'cors',
        cache: 'default',
        credentials: 'same-origin',
        referrerPolicy: 'no-referrer',
        redirect: 'follow',
        body: JSON.stringify(data)
      });
      
      fetch(myRequest)
      .then(response => response.json())
      .then(response => window.location = 'books.html');
    },
    clearForm() {
      this.form.find('#bookTitle').val('');
      this.form.find('#isbn').val('');
      this.form.find('#overdueFee').val('0.00');
      this.form.find('#publisher').val('');
      this.form.find('#datePublished').val('');
    }
  }
  App.init();
})(jQuery);