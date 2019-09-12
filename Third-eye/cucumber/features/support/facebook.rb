class Facebook

  def wait_for_element_to_display(element)
    Selenium::WebDriver::Wait.new(timeout: 30).until{$driver.find_element(css: element).displayed?}
  end

  def is_sign_up_button_displayed
    wait_for_element_to_display('#u_0_15')
    $driver.find_element(css: '#u_0_15').displayed?
  end

  def enter_username
    wait_for_element_to_display('#email')
    $driver.find_element(css: '#email').displayed?
  end
  def enter_password
    wait_for_element_to_display('#pass')
    $driver.find_element(css: '#pass').displayed?
  end
  def click_sign_in
    wait_for_element_to_display('#u_0_b')
    $driver.find_element(css: '#u_0_b').displayed?
  end

  def is_home_page_button_displayed
    wait_for_element_to_display('#u_0_b')
    $driver.find_element(css: '#u_0_b').displayed?
  end

end
