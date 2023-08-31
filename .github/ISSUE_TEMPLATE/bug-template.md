---
name: Bug template
about: " [Controller name, Method /endpoint] Bug' summary "
title: " [Controller name, Method /endpoint] Bug' summary "
labels: api-, bug
assignees: ''

---

**Environment:**

**Reproducible**: always.

**Preconditions**:
GreenCity container is built and running.
User is logged in as Admin

**Steps to reproduce**:
1. Select the “XXX” section.
2. Select the METHOD/endpoint.
3. Add the parameters/request body with the JSON data (e.g { "name": "string2", ...} )
4. Send the request.
5. Compare the returned response with the actual one.

**Actual result**:
Response code XXX and response body { "name": "string2", ...} is sent

**Expected result**:
Response code XXX and response body { "name": "string2", ...} is sent

**User story links**:
