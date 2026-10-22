from typing import List


class Solution:

  def minOperations(self, nums: List[int]) -> int:
    n = len(nums)
    zero = nums.index(0)

    def check(step: int) -> bool:
      for i in range(n):
        if nums[(zero + i * step) % n] != i:
          return False
      return True

    ans = float("inf")

    # Check if cyclic increasing (step = 1)
    if check(1):
      ans = min(ans, zero)
      ans = min(ans, n - zero + 2)

    # Check if cyclic decreasing (step = -1)
    if check(-1):
      ans = min(ans, zero + 2)
      ans = min(ans, n - zero)

    return ans if ans != float("inf") else -1