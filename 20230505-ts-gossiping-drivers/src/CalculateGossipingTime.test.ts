import {calculateGossipingTime} from './CalculateGossipingTime'

describe('Calculate Gossiping Time', () => {

    it('should be never when drivers do not meet in any of their route stops', () => {
        const routes = [[1, 2, 3], [4, 5, 6]]

        const result = calculateGossipingTime(routes)

        expect(result).toBe('never')
    })

    it('should take 0 time when all drivers meet at the initial stop', () => {
        const routes = [[1, 2], [1, 3]]

        const result = calculateGossipingTime(routes)

        expect(result).toBe('0')
    })

    it('should be never when not all drivers meet at the initial stop', () => {
        const routes = [[1, 2], [1, 3], [4, 5]]

        const result = calculateGossipingTime(routes)

        expect(result).toBe('never')
    })

    it('should take 1 minute when all drivers meet at the second stop', () => {
        const routes = [[1, 2], [3, 2]]

        const result = calculateGossipingTime(routes)

        expect(result).toBe('1')
    })
})
