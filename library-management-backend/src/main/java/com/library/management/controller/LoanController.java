package com.library.management.controller;

import com.library.management.model.Loan;
import com.library.management.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/borrow")
    public Loan borrowBook(@RequestParam Long userId, @RequestParam Long bookId) {
        return loanService.createLoan(userId, bookId);
    }

    @PostMapping("/return/{id}")
    public ResponseEntity<?> returnBook(@PathVariable Long id) {
        loanService.returnBook(id);
        return ResponseEntity.ok("Book returned successfully");
    }
}

