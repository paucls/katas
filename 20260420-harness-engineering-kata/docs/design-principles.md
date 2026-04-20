# Design Principles

This document captures the design principles applied during the refactoring of the WarehouseDeskApp.

## 1. Reduce Primitive Obsession

**Problem**: Using primitive types (strings, integers) and maps to represent domain concepts leads to weak typing and scattered data access patterns.

**Solution**: Extract domain classes that encapsulate related data and behavior.

**Example**: 
- Replaced separate maps (`orderStatus`, `orderSku`, `orderQty`) with a single `Order` class
- Created `Reservation` class to encapsulate reservation data
- Created `OrderStatus` enum to replace magic strings

## 2. Use Enums for Type Safety

**Problem**: Magic strings like `"SHIPPED"`, `"BACKORDER"`, `"CANCELLED"` are error-prone and provide no compile-time safety.

**Solution**: Use enums to represent finite sets of related constants.

**Example**: `OrderStatus` enum with values `SHIPPED`, `BACKORDER`, `CANCELLED`, `CANCELLED_AFTER_SHIP`

## 3. Extract Command Handlers

**Problem**: Large methods with many conditional branches (e.g., 160-line `processLine` method) are hard to read, test, and maintain.

**Solution**: Extract each command type into its own dedicated handler method.

**Example**: 
- `handleRecvCommand`, `handleSellCommand`, `handleCancelCommand`
- `handleReserveCommand`, `handleConfirmCommand`, `handleReleaseCommand`
- `handleCountCommand`, `handleDumpCommand`

## 4. Group Related Data

**Problem**: Data that belongs together is scattered across multiple maps, requiring coordinated updates.

**Solution**: Group related data into cohesive objects with clear invariants.

**Example**: `Order` class groups `id`, `sku`, `qty`, and `status` into a single object

## 5. Eliminate Duplication

**Problem**: Repeated calculations (e.g., `onHand - reserved`) appear in multiple places, increasing maintenance burden.

**Solution**: Extract common logic into helper methods.

**Example**: `getAvailableStock(sku)` helper method used by `handleSellCommand` and `handleReserveCommand`

## 6. Single Responsibility Principle

**Problem**: The main class handles command parsing, business logic, state management, and reporting.

**Solution**: Each method should have a single, well-defined responsibility.

**Example**: Command handlers focus only on their specific business logic, while `processLine` focuses only on dispatch.

## 7. Improve Encapsulation

**Problem**: Direct map access throughout the codebase makes it easy to introduce inconsistencies.

**Solution**: Use domain objects with controlled access to maintain invariants.

**Example**: `Order.status` field is now part of the object, not a separate map entry

## 8. Separate Data Classes

**Rule**: When a new model or data class is added, ensure it is in a separate file.

**Example**: `Reservation.java`, `Order.java`, `OrderStatus.java` are each in their own files

## 9. Preserve Public API During Refactoring

**Principle**: When improving design, keep the public API unchanged to avoid breaking tests and clients.

**Example**: All public methods (`seedData`, `processLine`, `getEventLog`, `getCashBalance`, `getPrice`, `setCurrentTimeMillis`) remained unchanged while internals were refactored
