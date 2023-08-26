Feature: Create booking

Scenario: create booking for person

Given create request using payload
When Add resourse And hit post method
Then verify booking id
Then verify status code