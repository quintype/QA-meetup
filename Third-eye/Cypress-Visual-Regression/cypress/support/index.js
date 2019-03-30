// ***********************************************************
// This example support/index.js is processed and
// loaded automatically before your test files.
//
// This is a great place to put global configuration and
// behavior that modifies Cypress.
//
// You can change the location of this file or turn off
// automatically serving support files with the
// 'supportFile' configuration option.
//
// You can read more here:
// https://on.cypress.io/configuration
// ***********************************************************

// Import commands.js using ES2015 syntax:
import './commands'

// Alternatively you can use CommonJS syntax:
// require('./commands')
Cypress.Screenshot.defaults({
    onBeforeScreenshot ($el) {
      const clock = $el.find("header[class='header-section js-header']")
      const minutes =$el.find("section[class='header-section js-header'][data-reactid='5']")
      const time  =$el.find('img[class="i-amphtml-fill-content i-amphtml-replaced-content"]')
      const money =$el.find('div[class="header-section__bottom__menu"]')
      const second =$el.find('div[class="breaking-news-sticky breaking-news-sticky--is-visible"]')
      const secondsecond =$el.find('aside[class="bq-live-chat tv-miniplayer"]')
     
     
  
      if (clock) {
        clock.hide()
      } 
      else if(time){
        time.hide()
      }
      else if(money){
        money.hide()
      }
      else if(second){
        second.hide()
      }
      else if(minutes){
        minutes.hide()
      }
      else if(secondsecond)
      secondsecond.hide()
    },
     
  
    onAfterScreenshot ($el, props) {
      const $clock = $el.find("header[class='header-section js-header']")
  
      if ($clock) {
        $clock.show()
      }
    }
  })
//   Cypress.Screenshot.defaults({
//     disableTimersAndAnimations: true
//   })trashAssetsBeforeRuns
Cypress.Screenshot.defaults({
  disableTimersAndAnimations: true})

    Cypress.on('uncaught:exception', (err, runnable) => {
      // returning false here prevents Cypress from
      // failing the test
      return false
    })
    // Cypress.Screenshot.defaults({
    //    x: 0, y: 0, width: 0, height: 400 
    //   })
    
   

  