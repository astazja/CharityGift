document.addEventListener("DOMContentLoaded", function() {

  /**
   * Form Select
   */
  class FormSelect {
    constructor($el) {
      this.$el = $el;
      this.options = [...$el.children];
      this.init();
    }

    init() {
      this.createElements();
      this.addEvents();
      this.$el.parentElement.removeChild(this.$el);
    }

    createElements() {
      // Input for value
      this.valueInput = document.createElement("input");
      this.valueInput.type = "text";
      this.valueInput.name = this.$el.name;

      // Dropdown container
      this.dropdown = document.createElement("div");
      this.dropdown.classList.add("dropdown");

      // List container
      this.ul = document.createElement("ul");

      // All list options
      this.options.forEach((el, i) => {
        const li = document.createElement("li");
        li.dataset.value = el.value;
        li.innerText = el.innerText;

        if (i === 0) {
          // First clickable option
          this.current = document.createElement("div");
          this.current.innerText = el.innerText;
          this.dropdown.appendChild(this.current);
          this.valueInput.value = el.value;
          li.classList.add("selected");
        }

        this.ul.appendChild(li);
      });

      this.dropdown.appendChild(this.ul);
      this.dropdown.appendChild(this.valueInput);
      this.$el.parentElement.appendChild(this.dropdown);
    }

    addEvents() {
      this.dropdown.addEventListener("click", e => {
        const target = e.target;
        this.dropdown.classList.toggle("selecting");

        // Save new value only when clicked on li
        if (target.tagName === "LI") {
          this.valueInput.value = target.dataset.value;
          this.current.innerText = target.innerText;
        }
      });
    }
  }
  document.querySelectorAll(".form-group--dropdown select").forEach(el => {
    new FormSelect(el);
  });

  /**
   * Hide elements when clicked on document
   */
  document.addEventListener("click", function(e) {
    const target = e.target;
    const tagName = target.tagName;

    if (target.classList.contains("dropdown")) return false;

    if (tagName === "LI" && target.parentElement.parentElement.classList.contains("dropdown")) {
      return false;
    }

    if (tagName === "DIV" && target.parentElement.classList.contains("dropdown")) {
      return false;
    }

    document.querySelectorAll(".form-group--dropdown .dropdown").forEach(el => {
      el.classList.remove("selecting");
    });
  });

  /**
   * Switching between form steps
   */
  class FormSteps {
    constructor(form) {
      this.$form = form;
      this.$next = form.querySelectorAll(".next-step");
      this.$prev = form.querySelectorAll(".prev-step");
      this.$step = form.querySelector(".form--steps-counter span");
      this.currentStep = 1;

      this.$stepInstructions = form.querySelectorAll(".form--steps-instructions p");
      const $stepForms = form.querySelectorAll("form > div");
      this.slides = [...this.$stepInstructions, ...$stepForms];

      this.init();
    }

    /**
     * Init all methods
     */
    init() {
      this.events();
      this.updateForm();
    }

    /**
     * All events that are happening in form
     */
    events() {
      // Next step
      this.$next.forEach(btn => {
        btn.addEventListener("click", e => {
          e.preventDefault();
          if(this.validation()) {
            this.currentStep++;
            this.updateForm();
          }
        });
      });

      // Previous step
      this.$prev.forEach(btn => {
        btn.addEventListener("click", e => {
          e.preventDefault();
          this.currentStep--;
          this.updateForm();
        });
      });

      // Form submit
      this.$form.querySelector("form").addEventListener("submit", e => this.submit(e));
    }

    /**
     * Validation - check current step
     */

    validation() {
      let result = false;
      switch (this.currentStep) {
        case 1:
          [...document.querySelectorAll("div[data-step='1'] label")].forEach(cat => {
            if(cat.querySelector("input[type='checkbox']").checked) {
              document.querySelector("div[data-step='1'] p.errorMessage").innerText = "";
              result = true;
            }
          });
          if(result) return true;
          document.querySelector("div[data-step='1'] p.errorMessage").innerText = "Zaznacz co najmniej jedną kategorię";
          return false;
        case 2:
          const bags = parseInt(document.querySelector("div[data-step='2'] input").value);
          if(bags > 0) {
            document.querySelector("div[data-step='2'] p.errorMessage").innerText = "";
            result = true;
          }
          if(result) return true;
          document.querySelector("div[data-step='2'] p.errorMessage").innerText = "Musisz podać co najmniej jeden worek";
          return false;
        case 3:
          [...document.querySelectorAll("div[data-step='3'] label")].forEach(label => {
            if(label.querySelector("input[type='radio']").checked) {
              document.querySelector("div[data-step='3'] p.errorMessage").innerText = "";
              result = true;
            }
          });
          if(result) return true;
          document.querySelector("div[data-step='3'] p.errorMessage").innerText = "Musisz wybrać fundację";
          return false;
        case 4:
          result = true;
          const inputs = document.querySelectorAll("div[data-step='4'] input[type='text'], div[data-step='4'] input[type='date'], div[data-step='4'] input[type='time']");
          const errorMsg = document.querySelectorAll("div[data-step='4'] p.errorMessage");
          if (inputs[0].value.replaceAll(" ", "") === "") {
            errorMsg[0].innerText = "Pole nie może być puste";
            result = false;
          }else {
            errorMsg[0].innerText = "";
          }
          if (inputs[1].value.replaceAll(" ", "") === "") {
            errorMsg[1].innerText = "Pole nie może być puste";
            result = false;
          }else {
            errorMsg[1].innerText = "";
          }
          let regex = /^[0-9]{2}-[0-9]{3}$/;
          if (!regex.test(inputs[2].value)) {
            errorMsg[2].innerText = "Nieprawidłowy kod pocztowy";
            result = false;
          }else {
            errorMsg[2].innerText = "";
          }
          const dateForm = new Date(inputs[3].value).getTime();
          const dateNow = new Date(Date.now()).getTime();
          if(!(dateForm > dateNow)) {
            errorMsg[3].innerText = "Nie możesz zamówić kuriera wcześniej, niż na jutro";
            result = false;
          }else {
            errorMsg[3].innerText = "";
          }
          const formHour = inputs[4].value.split(":")[0];
          if((formHour < 8) || (formHour >= 20)) {
            errorMsg[4].innerText = "Kurier pracuje od 8:00 do 20:00";
            result = false;
          }else {
            errorMsg[4].innerText = "";
          }
          return result;
      }
    }

    /**
     * Update form front-end
     * Show next or previous section etc.
     */
    updateForm() {
      this.$step.innerText = this.currentStep;

      // TODO: Validation

      this.slides.forEach(slide => {
        slide.classList.remove("active");

        if (slide.dataset.step == this.currentStep) {
          slide.classList.add("active");
        }
      });

      this.$stepInstructions[0].parentElement.parentElement.hidden = this.currentStep >= 5;
      this.$step.parentElement.hidden = this.currentStep >= 5;

      //get data from inputs and show them in summary

      if (this.currentStep === 5) {
        const list = document.querySelectorAll("div.summary ul");
        const summaryDesc = list[0].querySelectorAll("span.summary--text");
        const bags = parseInt(document.querySelector("div[data-step='2'] input").value);
        let bag_declination = '';
        let contain_declination = '';
        const bagsNumber = bags - Math.floor(bags /10) * 10;
        if (bags === 1) {
          bag_declination = "worek";
          contain_declination = "zawierający";
        }else if((bagsNumber === 0) || (bagsNumber >= 5)){
          bag_declination = "worków";
          contain_declination = "zawierających";
        }else if(bagsNumber < 5){
          bag_declination = "worki";
          contain_declination = "zawierające";
        }
        let context = "";
        [...document.querySelectorAll("div[data-step='1'] label input:checked ~ span.description")].forEach(cat => {
            context += cat.innerText + ", ";
        });
        context = context.slice(0, -2);
        summaryDesc[0].innerText = `${bags} ${bag_declination} ${contain_declination} ${context}`;
        [...document.querySelectorAll("div[data-step='3'] label")].forEach(inst => {
          if(inst.querySelector("input[type='radio']").checked) {
            summaryDesc[1].innerText = `Dla fundacji` + inst.querySelector('div.title').innerText;
          }
        });
        const addressSummary = [...list[1].querySelectorAll("li")];
        const addressForm = [...document.querySelectorAll("div[data-step='4'] input[type='text'], div[data-step='4'] input[type='date'], div[data-step='4'] input[type='time']")];
        for (let i = 0; i < addressSummary.length; i++) {
          addressSummary[i].innerText = addressForm[i].value;
        }
        const pickUpSummary = [...list[2].querySelectorAll("li")];
        pickUpSummary[0].innerText = addressForm[3].value;
        pickUpSummary[1].innerText = addressForm[4].value;
        const message = document.querySelector("div[data-step='4'] textarea").value;
        if(message === "") {
          pickUpSummary[2].innerText = "Brak uwag";
        } else {
          pickUpSummary[2].innerText = message;
        }
      }
    }
  }
  const form = document.querySelector(".form--steps");
  if (form !== null) {
    new FormSteps(form);
  }
});
