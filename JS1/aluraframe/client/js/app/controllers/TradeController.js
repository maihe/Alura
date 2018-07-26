class TradeController {

      constructor() {

            let $ = document.querySelector.bind(document);

            this._inputDate = $('#date');
            this._inputQuantity = $('#quantity');
            this._inputValue = $('#value');
            this._form = $("#tForm");
      }

      add(event) {
            event.preventDefault();

            let date = new Date(...this._inputDate
                  .value
                  .split('-')
                  .map((item, indice) => item - indice % 2)
            );


            let trade = new Trade(
                  date,
                  this._inputQuantity.value,
                  this._inputValue.value
            );

            console.log(trade);
            this.cleanForm();
      }

      cleanForm() {
           this._inputDate.value = "";
           this._inputDate.focus;
           this._inputQuantity.value = "";
           this._inputValue.value = "";
           
      }
}