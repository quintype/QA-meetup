describe('e2e test for the quint', () => {
    beforeEach(() => {
    cy.viewport(1366,768)
    })
    it('Take the Screenshot of the page',() => {
      cy.visit("https://github.com/Moin-A/FunctionalTest")
      cy.get('div[class="application-main "]').matchImageSnapshot('cover-page')
      
   
   
    })
    it('Take the Screenshot of the page',() => {
      cy.visit("https://github.com/Moin-A/NewFunctionalTest")
      cy.get('div[class="application-main "]').matchImageSnapshot('cover-page')
      
  })
})