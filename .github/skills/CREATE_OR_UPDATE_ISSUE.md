# Skill: CREATE_OR_UPDATE_ISSUE

## When to use
- Create a new issue from a repository issue template.
- Update an existing issue description to match the selected template.

## Goals
- Keep issue descriptions consistent with repository templates.
- Capture scope, acceptance criteria, and references clearly.
- Produce a ready-to-publish issue body.

## How to invoke
- Trigger phrase: `create/update issue`.
- Recommended inputs:
  - `issue_id`: existing issue number to update (optional when creating).
  - `template`: template file name in `.github/ISSUE_TEMPLATE` (default: `task-report.md`).
  - `title`: issue title (required when creating).
- Behavior:
  - If `issue_id` is provided, update that issue body with the template-based content.
  - If `issue_id` is missing, create a new issue with the generated title/body.
- Example:
  - `create/update issue issue_id=9 template=task-report.md`

## Steps
1. Read available templates from `.github/ISSUE_TEMPLATE`.
2. Select template based on user input (default: `task-report.md`).
3. Build issue content with concrete scope and acceptance criteria.
4. Keep all required sections from the template.
5. Create or update the issue through GitHub CLI/API.

## Output template
```md
### Job Description
<clear summary of the task and expected scope>

### Acceptance Criteria
- [ ] <criterion 1>
- [ ] <criterion 2>

### Reference Materials (If any)
<links or notes, optional>
```

## Notes
- Preserve template section headers exactly.
- Keep wording concise and implementation-focused.

Use English.
